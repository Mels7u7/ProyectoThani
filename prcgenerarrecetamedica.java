package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgenerarrecetamedica extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      prcgenerarrecetamedica pgm = new prcgenerarrecetamedica (-1);
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

   public prcgenerarrecetamedica( )
   {
      super( -1 , new ModelContext( prcgenerarrecetamedica.class ), "" );
      Application.init(com.projectthani.GXcfg.class);
   }

   public prcgenerarrecetamedica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgenerarrecetamedica.class ), "" );
   }

   public prcgenerarrecetamedica( int remoteHandle ,
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
      prcgenerarrecetamedica.this.AV2CitaId = aP0;
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

