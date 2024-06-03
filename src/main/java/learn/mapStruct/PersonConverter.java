//package learn.mapStruct;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.factory.Mappers;
//
///**
// * The interface Person converter.
// *
// * @author daixulin
// * @version : v1.0
// * @date 2020 -08-11 2:54 下午 周二
// */
//@Mapper
//public interface PersonConverter {
//    /**
//     * The constant INSTANCE.
//     */
//    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);
//
//
//    /**
//     * Do 2 dto person dto.
//     *
//     * @param personDO the person do
//     * @return the person dto
//     */
//    @Mappings(@Mapping(source = "name", target = "userName"))
//    PersonDTO do2dto(PersonDO personDO);
//}
