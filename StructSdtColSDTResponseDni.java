package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseDni", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseDni implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseDni( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseDni.class ));
   }

   public StructSdtColSDTResponseDni( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtColSDTResponseDni( java.util.Vector<StructSdtSDTResponseDni> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseDni",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseDni> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseDni> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseDni> item = new java.util.Vector<>();
}

