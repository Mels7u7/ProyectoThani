package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "wppacientegetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wppacientegetfilterdata_RESTInterfaceIN
{
   String AV72DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV72DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV72DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV72DDOName = "" ;
      }
      else
      {
         AV72DDOName= Value;
      }
   }


   String AV70SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV70SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV70SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV70SearchTxt = "" ;
      }
      else
      {
         AV70SearchTxt= Value;
      }
   }


   String AV71SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV71SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV71SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV71SearchTxtTo = "" ;
      }
      else
      {
         AV71SearchTxtTo= Value;
      }
   }


}

