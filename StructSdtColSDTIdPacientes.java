package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTIdPacientes", namespace ="ProjectThani")
public final  class StructSdtColSDTIdPacientes implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTIdPacientes( )
   {
      this( -1, new ModelContext( StructSdtColSDTIdPacientes.class ));
   }

   public StructSdtColSDTIdPacientes( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtColSDTIdPacientes( java.util.Vector<StructSdtSDTIdPacientes> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTIdPacientes",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTIdPacientes> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTIdPacientes> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTIdPacientes> item = new java.util.Vector<>();
}

