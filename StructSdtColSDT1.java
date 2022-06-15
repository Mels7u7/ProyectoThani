package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDT1", namespace ="ProjectThani")
public final  class StructSdtColSDT1 implements Cloneable, java.io.Serializable
{
   public StructSdtColSDT1( )
   {
      this( -1, new ModelContext( StructSdtColSDT1.class ));
   }

   public StructSdtColSDT1( int remoteHandle ,
                            ModelContext context )
   {
   }

   public  StructSdtColSDT1( java.util.Vector<StructSdtSDT1> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDT1",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDT1> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDT1> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDT1> item = new java.util.Vector<>();
}

