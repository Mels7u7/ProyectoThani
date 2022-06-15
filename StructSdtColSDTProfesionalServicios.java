package com.projectthani ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTProfesionalServicios", namespace ="ProjectThani")
public final  class StructSdtColSDTProfesionalServicios implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTProfesionalServicios( )
   {
      this( -1, new ModelContext( StructSdtColSDTProfesionalServicios.class ));
   }

   public StructSdtColSDTProfesionalServicios( int remoteHandle ,
                                               ModelContext context )
   {
   }

   public  StructSdtColSDTProfesionalServicios( java.util.Vector<StructSdtSDTProfesionalServicios> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTProfesionalServicios",namespace="ProjectThani")
   public java.util.Vector<StructSdtSDTProfesionalServicios> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTProfesionalServicios> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTProfesionalServicios> item = new java.util.Vector<>();
}

