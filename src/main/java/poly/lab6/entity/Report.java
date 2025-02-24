package poly.lab6.entity;

import java.io.Serializable;

public interface Report {
    Serializable getGroup();
    Double getSum();
    Long getCount();
    Double getAverage();
}
