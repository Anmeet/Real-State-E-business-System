package propertymanager;

import allocation.PropertyManagerAllocation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-31T16:33:35")
@StaticMetamodel(PropertyManager.class)
public class PropertyManager_ { 

    public static volatile SingularAttribute<PropertyManager, String> firstName;
    public static volatile SingularAttribute<PropertyManager, String> lastName;
    public static volatile SingularAttribute<PropertyManager, Long> phoneNumber;
    public static volatile SingularAttribute<PropertyManager, Long> mobile;
    public static volatile ListAttribute<PropertyManager, PropertyManagerAllocation> orders;
    public static volatile SingularAttribute<PropertyManager, Long> id;
    public static volatile SingularAttribute<PropertyManager, String> email;

}