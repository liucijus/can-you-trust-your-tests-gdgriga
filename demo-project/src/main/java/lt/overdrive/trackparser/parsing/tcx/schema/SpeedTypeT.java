//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.17 at 10:24:25 PM EET 
//


package lt.overdrive.trackparser.parsing.tcx.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpeedType_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SpeedType_t">
 *   &lt;restriction base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Token_t">
 *     &lt;enumeration value="Pace"/>
 *     &lt;enumeration value="Speed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SpeedType_t")
@XmlEnum
public enum SpeedTypeT {

    @XmlEnumValue("Pace")
    PACE("Pace"),
    @XmlEnumValue("Speed")
    SPEED("Speed");
    private final String value;

    SpeedTypeT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SpeedTypeT fromValue(String v) {
        for (SpeedTypeT c: SpeedTypeT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
