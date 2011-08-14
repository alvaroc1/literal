package play.modules.literal

import play.Play
import play.mvc._
import play.mvc.results._

object `package` {
	def Url (action: => Any) = new ScalaAction(action).actionDefinition.url
	
	def StaticUrl (uri:String) = Router.reverse(Play.getVirtualFile(uri))

	def Form (action: => Any, method:String="POST", style:String=null)( body: => xml.Node):xml.Elem = {
		val a = new ScalaAction(action).actionDefinition

		<form action={a.url.split('?')(0)} method={method} style={style}>
			{body}
		</form>
	}
}
