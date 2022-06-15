package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class config_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      config_dataprovider pgm = new config_dataprovider (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {
      @SuppressWarnings("unchecked")
      GXBCCollection<com.projectthani.SdtConfig>[] aP0 = new GXBCCollection[] {new GXBCCollection<com.projectthani.SdtConfig>()};

      try
      {
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      execute(aP0);
   }

   public config_dataprovider( )
   {
      super( -1 , new ModelContext( config_dataprovider.class ), "" );
      Application.init(com.projectthani.GXcfg.class);
   }

   public config_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( config_dataprovider.class ), "" );
   }

   public config_dataprovider( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<com.projectthani.SdtConfig> executeUdp( )
   {
      GXBCCollection<com.projectthani.SdtConfig>[] aP0 = new GXBCCollection[] {new GXBCCollection<com.projectthani.SdtConfig>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<com.projectthani.SdtConfig>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<com.projectthani.SdtConfig>[] aP0 )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.projectthani.aconfig_dataprovider(remoteHandle, context).execute( aP0 );
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

