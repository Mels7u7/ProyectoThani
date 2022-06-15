package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secgetadvancedsecurityuserfunctionalities extends GXProcedure
{
   public secgetadvancedsecurityuserfunctionalities( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secgetadvancedsecurityuserfunctionalities.class ), "" );
   }

   public secgetadvancedsecurityuserfunctionalities( int remoteHandle ,
                                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad> executeUdp( )
   {
      secgetadvancedsecurityuserfunctionalities.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>[] aP0 )
   {
      secgetadvancedsecurityuserfunctionalities.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = secgetadvancedsecurityuserfunctionalities.this.Gxm1rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm1rootcol = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>(com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad.class, "SecFunctionalitiesToLoad", "ProjectThani", remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad>[] aP0 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtSecFunctionalitiesToLoad> Gxm1rootcol ;
}

