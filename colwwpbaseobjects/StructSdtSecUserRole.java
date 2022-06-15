package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SecUserRole", namespace ="ProjectThani")
public final  class StructSdtSecUserRole implements Cloneable, java.io.Serializable
{
   public StructSdtSecUserRole( )
   {
      this( -1, new ModelContext( StructSdtSecUserRole.class ));
   }

   public StructSdtSecUserRole( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtSecUserRole( java.util.Vector<StructSdtSecUserRole> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SecUserRole",namespace="ProjectThani")
   public java.util.Vector<StructSdtSecUserRole> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSecUserRole> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSecUserRole> item = new java.util.Vector<>();
}

