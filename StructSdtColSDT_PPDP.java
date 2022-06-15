package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDT_PPDP", namespace ="ProjectThani")
public final  class StructSdtColSDT_PPDP implements Cloneable, java.io.Serializable
{
   public StructSdtColSDT_PPDP( )
   {
      this( -1, new ModelContext( StructSdtColSDT_PPDP.class ));
   }

   public StructSdtColSDT_PPDP( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColSDT_PPDP( java.util.Vector<StructSdtSDT_PPDP> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDT_PPDP",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDT_PPDP> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDT_PPDP> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDT_PPDP> item = new java.util.Vector<>();
}

