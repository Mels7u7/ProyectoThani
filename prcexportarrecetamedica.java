package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcexportarrecetamedica extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      prcexportarrecetamedica pgm = new prcexportarrecetamedica (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      int aP0 = 0;

      try
      {
         aP0 = (int) GXutil.lval( args[0]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public prcexportarrecetamedica( )
   {
      super( -1 , new ModelContext( prcexportarrecetamedica.class ), "" );
      Application.init(com.projectthani.GXcfg.class);
   }

   public prcexportarrecetamedica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcexportarrecetamedica.class ), "" );
   }

   public prcexportarrecetamedica( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      prcexportarrecetamedica.this.AV2CitaId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
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
   private int AV2CitaId ;
}

