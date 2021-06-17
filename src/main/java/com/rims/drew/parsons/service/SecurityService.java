package com.rims.drew.parsons.service;




public interface SecurityService
{
	String findLoggedInUsername();

    void autoLogin(String username, String password);

}
