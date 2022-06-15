package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class aconfig_dataprovider extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      aconfig_dataprovider pgm = new aconfig_dataprovider (-1);
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

   public aconfig_dataprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aconfig_dataprovider.class ), "" );
   }

   public aconfig_dataprovider( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBCCollection<com.projectthani.SdtConfig> executeUdp( )
   {
      aconfig_dataprovider.this.aP0 = new GXBCCollection[] {new GXBCCollection<com.projectthani.SdtConfig>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBCCollection<com.projectthani.SdtConfig>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBCCollection<com.projectthani.SdtConfig>[] aP0 )
   {
      aconfig_dataprovider.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   public static Object refClasses( )
   {
      GXutil.refClasses(config_dataprovider.class);
      return new com.projectthani.GXcfg();
   }

   protected void cleanup( )
   {
      this.aP0[0] = aconfig_dataprovider.this.Gxm1rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm1rootcol = new GXBCCollection<com.projectthani.SdtConfig>(com.projectthani.SdtConfig.class, "Config", "ProjectThani", remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBCCollection<com.projectthani.SdtConfig>[] aP0 ;
   private GXBCCollection<com.projectthani.SdtConfig> Gxm1rootcol ;
}

