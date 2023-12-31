import React from "react";
import * as Components from './Components';
import { useState } from "react";
import close from '../images/eye-close.png';
import open from '../images/eye-open.png';

import '../CSS/login.css';

function Login() {
    
    const [signIn, toggle] = useState(true);
    const [showPassword, setShowPassword] = useState(false);

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');


    const handlePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };


     return(
         <Components.Container>
             <Components.SignUpContainer signinIn={signIn}>
                 <Components.Form>
                     <Components.Title>Create Account</Components.Title>
                     <Components.Input type='text' placeholder='Name' />
                     <Components.Input type='email' placeholder='Email' />
                     <div className="pw-box">                        
                        <Components.InputPw type={showPassword ? 'text' : 'password'} placeholder='Password' />
                        <img className="close-icon" 
                             src={showPassword ? open : close} 
                             alt=""
                             onClick={handlePasswordVisibility}/>                                                
                      </div>
                      <div><h>${email}</h></div>
                     <Components.Button>Register</Components.Button>
                 </Components.Form>
             </Components.SignUpContainer>

             <Components.SignInContainer signinIn={signIn}>
                  <Components.Form>
                      <Components.Title>Sign in {email}</Components.Title>
                      <Components.Input type='email' placeholder='Email' value={email}
                          onChange={(e) => setEmail(e.target.value)}/>
                      <div className="pw-box">                        
                        <Components.InputPw type={showPassword ? 'text' : 'password'} placeholder='Password' value={password}
                            onChange={(e) => setPassword(e.target.value)} />
                        <img className="close-icon" 
                             src={showPassword ? open : close} 
                             alt=""                             
                             onClick={handlePasswordVisibility}/>                        
                      </div>
                      <Components.Anchor href='#'>Forgot your password?</Components.Anchor>
                      <Components.Button type="submit">Sign In</Components.Button>
                  </Components.Form>
             </Components.SignInContainer>

             <Components.OverlayContainer signinIn={signIn}>
                 <Components.Overlay signinIn={signIn}>

                 <Components.LeftOverlayPanel signinIn={signIn}>
                     <Components.Title>Welcome Back!</Components.Title>
                     <Components.Paragraph>
                         To keep connected with us please login with your personal info
                     </Components.Paragraph>
                     <Components.GhostButton onClick={() => toggle(true)}>
                         Sign In
                     </Components.GhostButton>
                     </Components.LeftOverlayPanel>

                     <Components.RightOverlayPanel signinIn={signIn}>
                       <Components.Title>Hello, Friend!</Components.Title>
                       <Components.Paragraph>
                           Enter Your personal details and start journey with us
                       </Components.Paragraph>
                           <Components.GhostButton onClick={() => toggle(false)}>
                               Register
                           </Components.GhostButton> 
                     </Components.RightOverlayPanel>
 
                 </Components.Overlay>
             </Components.OverlayContainer>

         </Components.Container>
     )
}

export default Login;
