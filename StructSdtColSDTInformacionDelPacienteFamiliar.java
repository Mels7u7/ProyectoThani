package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTInformacionDelPacienteFamiliar", namespace ="ProjectThani")
public final  class StructSdtColSDTInformacionDelPacienteFamiliar implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTInformacionDelPacienteFamiliar( )
   {
      this( -1, new ModelContext( StructSdtColSDTInformacionDelPacienteFamiliar.class ));
   }

   public StructSdtColSDTInformacionDelPacienteFamiliar( int remoteHandle ,
                                                         ModelContext context )
   {
   }

   public  StructSdtColSDTInformacionDelPacienteFamiliar( java.util.Vector<StructSdtSDTInformacionDelPacienteFamiliar> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTInformacionDelPacienteFamiliar",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTInformacionDelPacienteFamiliar> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTInformacionDelPacienteFamiliar> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTInformacionDelPacienteFamiliar> item = new java.util.Vector<>();
}

