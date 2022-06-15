package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColClinica", namespace ="ProjectThani")
public final  class StructSdtColClinica implements Cloneable, java.io.Serializable
{
   public StructSdtColClinica( )
   {
      this( -1, new ModelContext( StructSdtColClinica.class ));
   }

   public StructSdtColClinica( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtColClinica( java.util.Vector<StructSdtClinica> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Clinica",namespace="ProjectThani")
   public java.util.Vector<StructSdtClinica> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtClinica> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtClinica> item = new java.util.Vector<>();
}

