package week4.xpathbuilder;

/**
 * Created by bogdan on 4/8/2017.
 */
public class StringXPath {
    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    private StringXPath(XPathBuilder builder){
        this.expression = builder.expression;
    }

    public static class XPathBuilder {
        private String expression="";

        public StringXPath build(){
            return new StringXPath(this);
        }

        public XPathBuilder descOrSelf(){
            this.expression +="//";
            return this;
        }

        public XPathBuilder byTag(String tag){
            this.expression +=tag;
            return this;
        }

        public XPathBuilder byAttribute(String attrName, String attrValue){
            this.expression +="[@"+attrName+"=\'"+attrValue+"\'";
            return this;
        }

        public XPathBuilder step(){
            this.expression +="/";
            return this;
        }

        public XPathBuilder byContentEqNumVal(String contName, int contValue){
            this.expression +="["+contName+"="+contValue+"]";
            return this;
        }

        public XPathBuilder byContentEqStrVal(String contName, String contValue){
            this.expression +="["+contName+"=\'"+contValue+"\']";
            return this;
        }

        public XPathBuilder byPossition(int possition){
            this.expression +="["+possition+"]";
            return this;
        }

    }
}
