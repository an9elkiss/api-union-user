package com.an9elkiss.api.user.command;

public class UserCmd{

    private Integer id;

    private String name;

    private Integer roleId;

    private String password;

    public UserCmd(){
        
    }
    
    public UserCmd(Integer id, String password){
        super();
        this.id = id;
        this.password = password;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getRoleId(){
        return roleId;
    }

    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
