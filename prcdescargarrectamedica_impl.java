package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class prcdescargarrectamedica_impl extends GXWebProcedure
{
   public prcdescargarrectamedica_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "CitaId") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV11CitaId = (int)(GXutil.lval( gxfirstwebparm)) ;
      }
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P008R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CitaId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A19CitaId = P008R2_A19CitaId[0] ;
         A267RecetaMedicaNombreArchivo = P008R2_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = P008R2_n267RecetaMedicaNombreArchivo[0] ;
         A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A271RecetaArchivoTipo = P008R2_A271RecetaArchivoTipo[0] ;
         A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         A270RecetaMedicaArchivo = P008R2_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = P008R2_n270RecetaMedicaArchivo[0] ;
         A50RecetaMedicaId = P008R2_A50RecetaMedicaId[0] ;
         AV8FileName = A267RecetaMedicaNombreArchivo + "." + A271RecetaArchivoTipo ;
         AV9blob = A270RecetaMedicaArchivo ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV10HttpResponse.addHeader("Content-type", "application/download");
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV10HttpResponse.addHeader("Content-Disposition", "attachment; filename="+AV8FileName);
      }
      AV10HttpResponse.addFile(AV9blob);
      httpContext.nUserReturn = (byte)(1) ;
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      scmdbuf = "" ;
      P008R2_A19CitaId = new int[1] ;
      P008R2_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      P008R2_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      P008R2_A271RecetaArchivoTipo = new String[] {""} ;
      P008R2_A270RecetaMedicaArchivo = new String[] {""} ;
      P008R2_n270RecetaMedicaArchivo = new boolean[] {false} ;
      P008R2_A50RecetaMedicaId = new short[1] ;
      A267RecetaMedicaNombreArchivo = "" ;
      A270RecetaMedicaArchivo_Filename = "" ;
      A271RecetaArchivoTipo = "" ;
      A270RecetaMedicaArchivo_Filetype = "" ;
      A270RecetaMedicaArchivo = "" ;
      AV8FileName = "" ;
      AV9blob = "" ;
      AV10HttpResponse = httpContext.getHttpResponse();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcdescargarrectamedica__default(),
         new Object[] {
             new Object[] {
            P008R2_A19CitaId, P008R2_A267RecetaMedicaNombreArchivo, P008R2_n267RecetaMedicaNombreArchivo, P008R2_A271RecetaArchivoTipo, P008R2_A270RecetaMedicaArchivo, P008R2_n270RecetaMedicaArchivo, P008R2_A50RecetaMedicaId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short A50RecetaMedicaId ;
   private short Gx_err ;
   private int AV11CitaId ;
   private int A19CitaId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String A270RecetaMedicaArchivo_Filename ;
   private String A270RecetaMedicaArchivo_Filetype ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n270RecetaMedicaArchivo ;
   private String A270RecetaMedicaArchivo ;
   private String AV9blob ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private String AV8FileName ;
   private IDataStoreProvider pr_default ;
   private int[] P008R2_A19CitaId ;
   private String[] P008R2_A267RecetaMedicaNombreArchivo ;
   private boolean[] P008R2_n267RecetaMedicaNombreArchivo ;
   private String[] P008R2_A271RecetaArchivoTipo ;
   private String[] P008R2_A270RecetaMedicaArchivo ;
   private boolean[] P008R2_n270RecetaMedicaArchivo ;
   private short[] P008R2_A50RecetaMedicaId ;
   private com.genexus.internet.HttpResponse AV10HttpResponse ;
}

final  class prcdescargarrectamedica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P008R2", "SELECT [CitaId], [RecetaMedicaNombreArchivo], [RecetaArchivoTipo], [RecetaMedicaArchivo], [RecetaMedicaId] FROM [RecetaMedica] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((String[]) buf[4])[0] = rslt.getBLOBFile(4, rslt.getVarchar(3), rslt.getVarchar(2));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((short[]) buf[6])[0] = rslt.getShort(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

