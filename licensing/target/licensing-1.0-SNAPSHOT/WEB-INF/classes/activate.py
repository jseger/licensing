#!/usr/bin/python
# -*- coding: utf-8 -*-

"""
A simple program to test Franklin University Practicum
Software Licensing Modules
"""

"""
Local info for Tim:
Product Id: 850577f0-35d3-4b21-a7ab-19e1ef881555
License key: 6a373c20-58ac-4a1a-a280-ddf1e3d6d164
"""

import requests, uuid, ast
import simplejson as json
from Tkinter import Tk, BOTH, END
from ttk import Frame, Button, Label, Entry, Style
import tkMessageBox as box

## Not used until Web deployment: productid = '850577f0-35d3-4b21-a7ab-19e1ef881555'

class Activate(Frame):
    
    def __init__(self, parent):
        Frame.__init__(self, parent)

        self.parent = parent

        self.initUI()

    def initUI(self):
        self.parent.title("Software Activation")
        self.style = Style()
        self.style.theme_use("default")
        self.pack(fill=BOTH, expand=1)

        if(self.needsActivated()):
            idEntry = Entry(self, width=36)
            idEntry.place(x=175, y=20)
            idEntry.delete(0, END)
            idEntry.insert(0, "Enter a product id")
            
            keyEntry = Entry(self, width=36)
            keyEntry.place(x=175, y=40)
            keyEntry.delete(0, END)
            keyEntry.insert(0, "Enter your license key")
            
            activateButton = Button(self, text="Activate",
                                    command=lambda:self.activate(
                                        idEntry.get(), keyEntry.get()))
            activateButton.place(x=250, y=65)
        else:
            label = Label(self, text="Product has already been activated")
            label.pack()

    def needsActivated(self):
        decision = True
        with open('activation_data.txt', 'r') as f:
            data = f.read()
            dataDict = json.loads(data)
            if (type(dataDict) == dict):
                decision = self.check(data, dataDict)
        return decision

    def check(self, data, dDict):
        productid = '850577f0-35d3-4b21-a7ab-19e1ef881555'
        key = dDict.get('licenseKey')
        mac = uuid.getnode()
        url = ('http://127.0.0.1:8080/licensing/api/activate/' +
               productid + '/' + key + '/' + str(mac))
        response = requests.request("GET", url)
        responseData = response.json()
        if (dDict != responseData):
            with open('activation_data.txt', 'w') as f:
                f.write(json.dumps(responseData))
        return (not responseData.get('isActivated'))

    ## Activate this product
    def activate(self, pid, key):
        productid = pid
        mac = uuid.getnode()
        url = ('http://127.0.0.1:8080/licensing/api/activate/' +
               productid + '/' + key + '/' + str(mac))
        response = requests.request("POST", url)
        if (response.status_code == 200
            and response.headers.get('content-type') ==
            ('application/json;charset=ISO-8859-1')):
            data = response.json()
            with open('activation_data.txt', 'w') as f:
                f.write(json.dumps(data))
            if (type(data) == dict) and data.get('isActivated'):
                self.activationSuccess(data)
            else:
                self.activationFailed(data)
        else:
            self.activationFailed(response.text)

    ## If successful, go to main screen
    def activationSuccess(self, jsonData):
        for child in self.winfo_children():
            child.destroy()
        jsonData = json.dumps(jsonData, sort_keys=True, indent=4 * ' ')
        label = Label(self, text=jsonData)
        label.pack()

    ## If unsuccessful, show message
    def activationFailed(self, data):
        if (type(data) == dict):
            box.showerror("Activation Failure", data.get('message'))
        else:
            box.showerror("Activation Failure", "Server error, try again")


def main():
    root = Tk()
    root.geometry("600x200+150+150")
    app = Activate(root)
    root.mainloop()

if __name__ == '__main__':
    main()
