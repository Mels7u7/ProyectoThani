package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalEducacion", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalEducacion implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalEducacion( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalEducacion.class ));
   }

   public StructSdtColSDTProfesionalEducacion( int remoteHandle ,
                                               ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalEducacion( java.util.Vector<StructSdtSDTProfesionalEducacion> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalEducacion",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalEducacion> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalEducacion> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalEducacion> item = new java.util.Vector<>();
}

