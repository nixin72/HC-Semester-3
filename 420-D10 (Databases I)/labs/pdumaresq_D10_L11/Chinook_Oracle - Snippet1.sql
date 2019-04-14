/*******************************************************************************
   Chinook Database - Version 1.4
   Script: Chinook_Oracle.sql
   Description: Creates and populates the Chinook database.
   DB Server: Oracle
   Author: Luis Rocha
   License: http://www.codeplex.com/ChinookDatabase/license
********************************************************************************/

/*
Same as the default create script without the create of the chinook user required.
This script is intended to run within the context of your personal account
*/
drop table Album cascade constraints;
drop table Artist cascade constraints;
drop table Customer cascade constraints;
drop table Employee cascade constraints;
drop table Genre cascade constraints;
drop table Invoice cascade constraints;
drop table InvoiceLine cascade constraints;
drop table MediaType cascade constraints;
drop table Playlist cascade constraints;
drop table PlaylistTrack cascade constraints;
drop table Track cascade constraints;

