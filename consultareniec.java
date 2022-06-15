package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class consultareniec extends GXProcedure
{
   public consultareniec( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( consultareniec.class ), "" );
   }

   public consultareniec( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        int[] aP1 ,
                        String[] aP2 ,
                        String aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             int[] aP1 ,
                             String[] aP2 ,
                             String aP3 ,
                             String aP4 )
   {
      consultareniec.this.AV10requestBody = aP0;
      consultareniec.this.aP1 = aP1;
      consultareniec.this.aP2 = aP2;
      consultareniec.this.AV11headername = aP3;
      consultareniec.this.AV12headervalue = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13httpclient = (com.genexus.internet.HttpClient)new com.genexus.internet.HttpClient();
      AV13httpclient.setTimeout( (short)(300) );
      if ( ! (GXutil.strcmp("", AV11headername)==0) )
      {
         AV13httpclient.addHeader(AV11headername, AV12headervalue);
      }
      AV13httpclient.addHeader("Authorization", "Bearer 20bccfd327f2866daaaff28d0a77eec31c08f2043e2b9522de0700b7a31d45f5");
      AV13httpclient.execute("GET", "https://consulta.api-peru.com/api/dni/"+GXutil.trim( AV10requestBody));
      AV14httpstatus = AV13httpclient.getStatusCode() ;
      AV17result = AV13httpclient.getString() ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = consultareniec.this.AV14httpstatus;
      this.aP2[0] = consultareniec.this.AV17result;
      CloseOpenCursors();
      AV13httpclient.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17result = "" ;
      AV13httpclient = new com.genexus.internet.HttpClient();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV14httpstatus ;
   private String AV10requestBody ;
   private String AV11headername ;
   private String AV12headervalue ;
   private String AV17result ;
   private int[] aP1 ;
   private String[] aP2 ;
   private com.genexus.internet.HttpClient AV13httpclient ;
}

