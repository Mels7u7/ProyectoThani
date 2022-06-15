package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class prcdescargararchivo_impl extends GXWebProcedure
{
   public prcdescargararchivo_impl( com.genexus.internet.HttpContext context )
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
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV13Val = GXutil.strtobool( httpContext.GetPar( "Val")) ;
         }
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
      /* Using cursor P007F3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CitaId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000CitaId = P007F3_A40000CitaId[0] ;
         n40000CitaId = P007F3_n40000CitaId[0] ;
      }
      else
      {
         A40000CitaId = 0 ;
         n40000CitaId = false ;
      }
      pr_default.close(0);
      AV12ValId = A40000CitaId ;
      if ( AV12ValId > 0 )
      {
         AV13Val = true ;
      }
      else
      {
         AV13Val = false ;
      }
      if ( AV13Val )
      {
         /* Using cursor P007F4 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV11CitaId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A19CitaId = P007F4_A19CitaId[0] ;
            A267RecetaMedicaNombreArchivo = P007F4_A267RecetaMedicaNombreArchivo[0] ;
            n267RecetaMedicaNombreArchivo = P007F4_n267RecetaMedicaNombreArchivo[0] ;
            A270RecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
            A271RecetaArchivoTipo = P007F4_A271RecetaArchivoTipo[0] ;
            A270RecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
            A270RecetaMedicaArchivo = P007F4_A270RecetaMedicaArchivo[0] ;
            n270RecetaMedicaArchivo = P007F4_n270RecetaMedicaArchivo[0] ;
            A50RecetaMedicaId = P007F4_A50RecetaMedicaId[0] ;
            AV8FileName = A267RecetaMedicaNombreArchivo + "." + A271RecetaArchivoTipo ;
            AV9blob = A270RecetaMedicaArchivo ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
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
         pr_default.close(0);
         returnInSub = true;
         cleanup();
         if (true) return;
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
      P007F3_A40000CitaId = new int[1] ;
      P007F3_n40000CitaId = new boolean[] {false} ;
      P007F4_A19CitaId = new int[1] ;
      P007F4_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      P007F4_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      P007F4_A271RecetaArchivoTipo = new String[] {""} ;
      P007F4_A270RecetaMedicaArchivo = new String[] {""} ;
      P007F4_n270RecetaMedicaArchivo = new boolean[] {false} ;
      P007F4_A50RecetaMedicaId = new short[1] ;
      A267RecetaMedicaNombreArchivo = "" ;
      A270RecetaMedicaArchivo_Filename = "" ;
      A271RecetaArchivoTipo = "" ;
      A270RecetaMedicaArchivo_Filetype = "" ;
      A270RecetaMedicaArchivo = "" ;
      AV8FileName = "" ;
      AV9blob = "" ;
      AV10HttpResponse = httpContext.getHttpResponse();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.prcdescargararchivo__default(),
         new Object[] {
             new Object[] {
            P007F3_A40000CitaId, P007F3_n40000CitaId
            }
            , new Object[] {
            P007F4_A19CitaId, P007F4_A267RecetaMedicaNombreArchivo, P007F4_n267RecetaMedicaNombreArchivo, P007F4_A271RecetaArchivoTipo, P007F4_A270RecetaMedicaArchivo, P007F4_n270RecetaMedicaArchivo, P007F4_A50RecetaMedicaId
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
   private int A40000CitaId ;
   private int AV12ValId ;
   private int A19CitaId ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String scmdbuf ;
   private String A270RecetaMedicaArchivo_Filename ;
   private String A270RecetaMedicaArchivo_Filetype ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV13Val ;
   private boolean n40000CitaId ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n270RecetaMedicaArchivo ;
   private boolean returnInSub ;
   private String A270RecetaMedicaArchivo ;
   private String AV9blob ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private String AV8FileName ;
   private IDataStoreProvider pr_default ;
   private int[] P007F3_A40000CitaId ;
   private boolean[] P007F3_n40000CitaId ;
   private int[] P007F4_A19CitaId ;
   private String[] P007F4_A267RecetaMedicaNombreArchivo ;
   private boolean[] P007F4_n267RecetaMedicaNombreArchivo ;
   private String[] P007F4_A271RecetaArchivoTipo ;
   private String[] P007F4_A270RecetaMedicaArchivo ;
   private boolean[] P007F4_n270RecetaMedicaArchivo ;
   private short[] P007F4_A50RecetaMedicaId ;
   private com.genexus.internet.HttpResponse AV10HttpResponse ;
}

final  class prcdescargararchivo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007F3", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT [CitaId] AS CitaId FROM [Cita] WHERE [CitaId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P007F4", "SELECT [CitaId], [RecetaMedicaNombreArchivo], [RecetaArchivoTipo], [RecetaMedicaArchivo], [RecetaMedicaId] FROM [RecetaMedica] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
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
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

