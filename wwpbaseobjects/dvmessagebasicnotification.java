package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dvmessagebasicnotification extends GXProcedure
{
   public dvmessagebasicnotification( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dvmessagebasicnotification.class ), "" );
   }

   public dvmessagebasicnotification( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 )
   {
      dvmessagebasicnotification.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String[] aP5 )
   {
      dvmessagebasicnotification.this.AV36Title = aP0;
      dvmessagebasicnotification.this.AV34Text = aP1;
      dvmessagebasicnotification.this.AV38Type = aP2;
      dvmessagebasicnotification.this.AV18ControlSelector = aP3;
      dvmessagebasicnotification.this.AV23Hide = aP4;
      dvmessagebasicnotification.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV31Parms ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.wwpbaseobjects.dvmessagenotification(remoteHandle, context).execute( AV36Title, AV34Text, AV38Type, AV18ControlSelector, (short)(0), (short)(0), "N", "na", DecimalUtil.doubleToDec(0), AV23Hide, 0, "na", "na", "na", "", "N", "N", (short)(0), "true", "na", "false", "false", "na", "", "", "na", DecimalUtil.doubleToDec(0), "na", "na", "", "", GXv_char2) ;
      dvmessagebasicnotification.this.GXt_char1 = GXv_char2[0] ;
      AV31Parms = GXt_char1 ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = dvmessagebasicnotification.this.AV31Parms;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31Parms = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV36Title ;
   private String AV34Text ;
   private String AV38Type ;
   private String AV18ControlSelector ;
   private String AV23Hide ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV31Parms ;
   private String[] aP5 ;
}

