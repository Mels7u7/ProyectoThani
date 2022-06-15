package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "wpbandejacitasgetfilterdata_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class wpbandejacitasgetfilterdata_RESTInterfaceIN
{
   String AV81DDOName;
   @JsonProperty("DDOName")
   public String getDDOName( )
   {
      if ( GXutil.strcmp(AV81DDOName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV81DDOName ;
      }
   }

   @JsonProperty("DDOName")
   public void setDDOName(  String Value )
   {
      if ( Value == null )
      {
         AV81DDOName = "" ;
      }
      else
      {
         AV81DDOName= Value;
      }
   }


   String AV79SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV79SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV79SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV79SearchTxt = "" ;
      }
      else
      {
         AV79SearchTxt= Value;
      }
   }


   String AV80SearchTxtTo;
   @JsonProperty("SearchTxtTo")
   public String getSearchTxtTo( )
   {
      if ( GXutil.strcmp(AV80SearchTxtTo, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV80SearchTxtTo ;
      }
   }

   @JsonProperty("SearchTxtTo")
   public void setSearchTxtTo(  String Value )
   {
      if ( Value == null )
      {
         AV80SearchTxtTo = "" ;
      }
      else
      {
         AV80SearchTxtTo= Value;
      }
   }


}

