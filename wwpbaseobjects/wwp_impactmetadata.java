package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_impactmetadata extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.projectthani.GXcfg.class);
      wwp_impactmetadata pgm = new wwp_impactmetadata (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public wwp_impactmetadata( )
   {
      super( -1 , new ModelContext( wwp_impactmetadata.class ), "" );
      Application.init(com.projectthani.GXcfg.class);
   }

   public wwp_impactmetadata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_impactmetadata.class ), "" );
   }

   public wwp_impactmetadata( int remoteHandle ,
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
      new com.projectthani.wwpbaseobjects.awwp_impactmetadata(remoteHandle, context).execute(  );
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

