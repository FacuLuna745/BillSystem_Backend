package com.um.disenio.billsystem.common;

import java.io.Serializable;

public interface Active <ID extends Serializable> {
    ID getId();
    void setActive(Boolean active);
    Boolean getActive();
}
