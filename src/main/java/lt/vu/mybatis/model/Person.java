package lt.vu.mybatis.model;

public class Person {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PERSON.ID
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PERSON.DESCRIPTION
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PERSON.FULL_NAME
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    private String fullName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PERSON.ID
     *
     * @return the value of PUBLIC.PERSON.ID
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PERSON.ID
     *
     * @param id the value for PUBLIC.PERSON.ID
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PERSON.DESCRIPTION
     *
     * @return the value of PUBLIC.PERSON.DESCRIPTION
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PERSON.DESCRIPTION
     *
     * @param description the value for PUBLIC.PERSON.DESCRIPTION
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PERSON.FULL_NAME
     *
     * @return the value of PUBLIC.PERSON.FULL_NAME
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PERSON.FULL_NAME
     *
     * @param fullName the value for PUBLIC.PERSON.FULL_NAME
     *
     * @mbg.generated Sun May 01 01:47:13 EEST 2022
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}