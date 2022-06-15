package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTCitaData", namespace ="ProjectThani")
public final  class StructSdtColSDTCitaData implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTCitaData( )
   {
      this( -1, new ModelContext( StructSdtColSDTCitaData.class ));
   }

   public StructSdtColSDTCitaData( int remoteHandle ,
                                   ModelContext context )
   {
   }

   public  StructSdtColSDTCitaData( java.util.Vector<StructSdtSDTCitaData> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTCitaData",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTCitaData> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTCitaData> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTCitaData> item = new java.util.Vector<>();
}

