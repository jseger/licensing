/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.franklin.licensing.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/home")
public class HomeActionBean extends BaseActionBean {
    
    @DefaultHandler
    public Resolution index(){
        return new ForwardResolution("/WEB-INF/jsp/index.jsp");
    }
    
    @HandlesEvent("sampleindex")
    public Resolution sampleIndex(){
        return new ForwardResolution("/WEB-INF/jsp/index_old.jsp");
    }
}
