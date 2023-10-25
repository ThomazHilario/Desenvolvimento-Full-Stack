import type { AppProps } from 'next/app';
import Head from 'next/head';
import 'bootstrap/dist/css/bootstrap.css'
import '../styles/table.css'
function myApp({Component, pageProps}:AppProps){
  return(
    <>
      <Head>
        <meta name='viewport' content='width=device-width, initial-scale=1' />
      </Head>
      <Component {...pageProps}/>
    </>
  )
}

export default myApp