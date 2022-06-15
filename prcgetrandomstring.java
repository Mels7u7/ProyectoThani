package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetrandomstring extends GXProcedure
{
   public prcgetrandomstring( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetrandomstring.class ), "" );
   }

   public prcgetrandomstring( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      prcgetrandomstring.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      prcgetrandomstring.this.AV12DisponibilidadId = aP0;
      prcgetrandomstring.this.AV9Size = aP1;
      prcgetrandomstring.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8i = (short)(1) ;
      while ( AV8i <= AV9Size )
      {
         /* User Code */
          java.util.Random rand = new java.util.Random();
         /* User Code */
          int n = rand.nextInt(25);
         /* User Code */
          AV13random = n;
         AV11letra = GXutil.chr( (short)(97+AV13random)) ;
         AV10TextoRandom += AV11letra ;
         AV8i = (short)(AV8i+1) ;
      }
      AV10TextoRandom = GXutil.trim( GXutil.str( AV12DisponibilidadId, 8, 0)) + AV10TextoRandom ;
      AV10TextoRandom = GXutil.substring( AV10TextoRandom, 1, AV9Size) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = prcgetrandomstring.this.AV10TextoRandom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10TextoRandom = "" ;
      AV11letra = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9Size ;
   private short AV8i ;
   private short Gx_err ;
   private int AV12DisponibilidadId ;
   private int AV13random ;
   private String AV11letra ;
   private String AV10TextoRandom ;
   private String[] aP2 ;
}

