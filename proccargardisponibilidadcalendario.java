package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class proccargardisponibilidadcalendario extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      proccargardisponibilidadcalendario pgm = new proccargardisponibilidadcalendario (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      java.util.Date aP0 = GXutil.nullDate();
      java.util.Date aP1 = GXutil.nullDate();
      com.projectthani.SdtSchedulerEvents[] aP2 = new com.projectthani.SdtSchedulerEvents[] {new com.projectthani.SdtSchedulerEvents()};

      try
      {
         aP0 = (java.util.Date) localUtil.ctod( args[0], 3);
         aP1 = (java.util.Date) localUtil.ctod( args[1], 3);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0, aP1, aP2);
   }

   public proccargardisponibilidadcalendario( )
   {
      super( -1 , new ModelContext( proccargardisponibilidadcalendario.class ), "" );
      Application.init(com.projectthani.GXcfg.class);
   }

   public proccargardisponibilidadcalendario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( proccargardisponibilidadcalendario.class ), "" );
   }

   public proccargardisponibilidadcalendario( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.projectthani.SdtSchedulerEvents executeUdp( java.util.Date aP0 ,
                                                          java.util.Date aP1 )
   {
      com.projectthani.SdtSchedulerEvents[] aP2 = new com.projectthani.SdtSchedulerEvents[] {new com.projectthani.SdtSchedulerEvents()};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( java.util.Date aP0 ,
                        java.util.Date aP1 ,
                        com.projectthani.SdtSchedulerEvents[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( java.util.Date aP0 ,
                             java.util.Date aP1 ,
                             com.projectthani.SdtSchedulerEvents[] aP2 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.projectthani.aproccargardisponibilidadcalendario(remoteHandle, context).execute( aP0, aP1, aP2 );
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}

