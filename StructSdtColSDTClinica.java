package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTClinica", namespace ="ProjectThani")
public final  class StructSdtColSDTClinica implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTClinica( )
   {
      this( -1, new ModelContext( StructSdtColSDTClinica.class ));
   }

   public StructSdtColSDTClinica( int remoteHandle ,
                                  ModelContext context )
   {
   }

   public  StructSdtColSDTClinica( java.util.Vector<StructSdtSDTClinica> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTClinica",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTClinica> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTClinica> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTClinica> item = new java.util.Vector<>();
}

