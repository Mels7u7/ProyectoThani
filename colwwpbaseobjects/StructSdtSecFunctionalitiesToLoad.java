package com.projectthani.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SecFunctionalitiesToLoad", namespace ="ProjectThani")
public final  class StructSdtSecFunctionalitiesToLoad implements Cloneable, java.io.Serializable
{
   public StructSdtSecFunctionalitiesToLoad( )
   {
      this( -1, new ModelContext( StructSdtSecFunctionalitiesToLoad.class ));
   }

   public StructSdtSecFunctionalitiesToLoad( int remoteHandle ,
                                             ModelContext context )
   {
   }

   public  StructSdtSecFunctionalitiesToLoad( java.util.Vector<StructSdtSecFunctionalitiesToLoad> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SecFunctionalitiesToLoad",namespace="ProjectThani")
   public java.util.Vector<StructSdtSecFunctionalitiesToLoad> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSecFunctionalitiesToLoad> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSecFunctionalitiesToLoad> item = new java.util.Vector<>();
}

