package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.NONE)
@javax.xml.bind.annotation.XmlType(name = "disponibilidadloaddvcombo_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class disponibilidadloaddvcombo_RESTInterfaceIN
{
   String AV17ComboName;
   @JsonProperty("ComboName")
   public String getComboName( )
   {
      if ( GXutil.strcmp(AV17ComboName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV17ComboName ;
      }
   }

   @JsonProperty("ComboName")
   public void setComboName(  String Value )
   {
      if ( Value == null )
      {
         AV17ComboName = "" ;
      }
      else
      {
         AV17ComboName= Value;
      }
   }


   String AV19TrnMode;
   @JsonProperty("TrnMode")
   public String getTrnMode( )
   {
      if ( GXutil.strcmp(AV19TrnMode, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV19TrnMode ;
      }
   }

   @JsonProperty("TrnMode")
   public void setTrnMode(  String Value )
   {
      if ( Value == null )
      {
         AV19TrnMode = "" ;
      }
      else
      {
         AV19TrnMode= Value;
      }
   }


   boolean AV21IsDynamicCall;
   @JsonProperty("IsDynamicCall")
   public boolean getIsDynamicCall( )
   {
      return AV21IsDynamicCall ;
   }

   @JsonProperty("IsDynamicCall")
   public void setIsDynamicCall(  boolean Value )
   {
      AV21IsDynamicCall= Value;
   }


   String AV26DisponibilidadId;
   @JsonProperty("DisponibilidadId")
   public String getDisponibilidadId( )
   {
      return AV26DisponibilidadId ;
   }

   @JsonProperty("DisponibilidadId")
   public void setDisponibilidadId(  String Value )
   {
      AV26DisponibilidadId= Value;
   }


   String AV27Cond_ProfesionalId;
   @JsonProperty("Cond_ProfesionalId")
   public String getCond_ProfesionalId( )
   {
      return AV27Cond_ProfesionalId ;
   }

   @JsonProperty("Cond_ProfesionalId")
   public void setCond_ProfesionalId(  String Value )
   {
      AV27Cond_ProfesionalId= Value;
   }


   String AV12SearchTxt;
   @JsonProperty("SearchTxt")
   public String getSearchTxt( )
   {
      if ( GXutil.strcmp(AV12SearchTxt, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV12SearchTxt ;
      }
   }

   @JsonProperty("SearchTxt")
   public void setSearchTxt(  String Value )
   {
      if ( Value == null )
      {
         AV12SearchTxt = "" ;
      }
      else
      {
         AV12SearchTxt= Value;
      }
   }


}

