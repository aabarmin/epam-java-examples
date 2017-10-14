<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <h1>
            This is header
        </h1>
        <xsl:apply-templates />
    </xsl:template>

    <xsl:template match="definition">
        <p>
            This is definition:
        </p>
        <ul>
            <li>
                <xsl:value-of select="@startState" />
            </li>
            <li>
                <xsl:value-of select="@startEvent" />
            </li>
            <li>
                <xsl:value-of select="@handler" />
            </li>
        </ul>
        <xsl:apply-templates />
    </xsl:template>

    <xsl:template match="transition">
        <p>
            Transition:
            <xsl:call-template name="transition-template">
                <xsl:with-param name="current-node">
                    <xsl:value-of select="@from" />
                </xsl:with-param>
            </xsl:call-template>
        </p>
    </xsl:template>

    <xsl:template name="transition-template">
        <xsl:param name="current-node" />

        Transition template
        <xsl:value-of select="$current-node" />
    </xsl:template>

</xsl:stylesheet>