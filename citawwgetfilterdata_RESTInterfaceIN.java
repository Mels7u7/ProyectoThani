package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "citawwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class citawwgetfilterdata_RESTInterfaceIN
{
   String AV63DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV63DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV63DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV63DDOName = "" ;
      }
      else
      {
         AV63DDOName= Value;
      }
   }


   String AV61SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV61SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV61SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV61SearchTxt = "" ;
      }
      else
      {
         AV61SearchTxt= Value;
      }
   }


   String AV62SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV62SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV62SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV62SearchTxtTo = "" ;
      }
      else
      {
         AV62SearchTxtTo= Value;
      }
   }


}

