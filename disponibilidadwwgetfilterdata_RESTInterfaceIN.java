package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "disponibilidadwwgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class disponibilidadwwgetfilterdata_RESTInterfaceIN
{
   String AV59DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV59DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV59DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV59DDOName = "" ;
      }
      else
      {
         AV59DDOName= Value;
      }
   }


   String AV57SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV57SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV57SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV57SearchTxt = "" ;
      }
      else
      {
         AV57SearchTxt= Value;
      }
   }


   String AV58SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV58SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV58SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV58SearchTxtTo = "" ;
      }
      else
      {
         AV58SearchTxtTo= Value;
      }
   }


}

