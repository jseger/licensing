DROP trigger set_max_date;

CREATE TRIGGER set_max_date BEFORE INSERT ON `frank73_f13lic`.`license` 
FOR EACH ROW SET NEW.expiration_date = 
IFNULL(NEW.expiration_date, STR_TO_DATE('31,12,9999','%d,%m,%Y'));