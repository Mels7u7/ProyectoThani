package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTResponseTokenSession200", namespace ="ProjectThani")
public final  class StructSdtColSDTResponseTokenSession200 implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTResponseTokenSession200( )
   {
      this( -1, new ModelContext( StructSdtColSDTResponseTokenSession200.class ));
   }

   public StructSdtColSDTResponseTokenSession200( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColSDTResponseTokenSession200( java.util.Vector<StructSdtSDTResponseTokenSession200> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTResponseTokenSession200",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTResponseTokenSession200> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTResponseTokenSession200> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTResponseTokenSession200> item = new java.util.Vector<>();
}

