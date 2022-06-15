package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseWSDni", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseWSDni implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseWSDni( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseWSDni.class ));
   }

   public StructSdtColSDTResponseWSDni( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColSDTResponseWSDni( java.util.Vector<StructSdtSDTResponseWSDni> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseWSDni",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseWSDni> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseWSDni> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseWSDni> item = new java.util.Vector<>();
}

