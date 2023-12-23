package model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "enum")
@XmlEnum
public enum AccessType {
    @XmlEnumValue(value = "read")
    READ,
    @XmlEnumValue(value = "edit")
    EDIT;
}
