package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "AccessType")
@XmlEnum
public enum AccessType {
    @XmlEnumValue(value = "READ")
    READ,
    @XmlEnumValue(value = "EDIT")
    EDIT;
}
