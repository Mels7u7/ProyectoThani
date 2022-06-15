package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secupdatefuncionalities extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      secupdatefuncionalities pgm = new secupdatefuncionalities (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public secupdatefuncionalities( )
   {
      super( -1 , new ModelContext( secupdatefuncionalities.class ), "" );
      Application.init(com.projectthani.GXcfg.class);
   }

   public secupdatefuncionalities( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secupdatefuncionalities.class ), "" );
   }

   public secupdatefuncionalities( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      new com.projectthani.wwpbaseobjects.asecupdatefuncionalities(remoteHandle, context).execute(  );
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

