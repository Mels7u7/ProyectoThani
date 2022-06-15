package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSugerenciasMejorasPlataforma", namespace ="ProjectThani")
public final  class StructSdtColSugerenciasMejorasPlataforma implements Cloneable, java.io.Serializable
{
   public StructSdtColSugerenciasMejorasPlataforma( )
   {
      this( -1, new ModelContext( StructSdtColSugerenciasMejorasPlataforma.class ));
   }

   public StructSdtColSugerenciasMejorasPlataforma( int remoteHandle ,
                                                    ModelContext context )
   {
   }

   public  StructSdtColSugerenciasMejorasPlataforma( java.util.Vector<StructSdtSugerenciasMejorasPlataforma> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="SugerenciasMejorasPlataforma",namespace="ProjectThani")
   public java.util.Vector<StructSdtSugerenciasMejorasPlataforma> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSugerenciasMejorasPlataforma> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSugerenciasMejorasPlataforma> item = new java.util.Vector<>();
}

