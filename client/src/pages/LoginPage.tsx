import {useContext, useState} from "react";
import User from "../models/User";
import axios from "axios";
import { BACKEND_URL } from "../constant";
import {AuthContext, AuthContextType, UserContext} from "../AuthContext";
import {useNavigate} from "react-router-dom";

export const LoginPage = () => {
    const [user, setUser] = useState<User>({ email: "", password: "" });
    const { user: loginUser, setUser: setLoginUser } = useContext(UserContext);
    const navigate = useNavigate();

    function login(event: React.FormEvent) {
        event.preventDefault();
        console.log(user);
        axios.post("http://localhost:8070/api/auth/login", user)
            .then(res => {
                console.log(res);
                sessionStorage.setItem("token", res.data.response);
                setLoginUser(user);
                navigate("/dashboard");
            })
            .catch(err => {
                console.error(err);
            });
    }

    return (
        <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-blue-500 to-indigo-600">
            <div className="bg-white p-10 rounded-2xl shadow-xl w-full max-w-md">
                <h1 className="text-3xl font-bold text-center text-gray-800 mb-6">Login to Your Account</h1>
                <form className="space-y-6" onSubmit={login}>
                    <div>
                        <label htmlFor="email" className="block text-sm font-medium text-gray-700">Email address</label>
                        <input
                            id="email"
                            name="email"
                            type="email"
                            placeholder="admin@gmail.com"
                            className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
                            onChange={(ev) => {
                                setUser({ ...user, email: ev.currentTarget.value });
                            }}
                            required
                        />
                    </div>
                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-gray-700">Password</label>
                        <input
                            id="password"
                            name="password"
                            type="password"
                            placeholder="••••••••"
                            className="mt-1 block w-full px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
                            onChange={(ev) => {
                                setUser({ ...user, password: ev.currentTarget.value });
                            }}
                            required
                        />
                    </div>
                    <button
                        type="submit"
                        className="w-full py-2 px-4 bg-blue-600 hover:bg-blue-700 text-white font-semibold rounded-lg shadow-md focus:outline-none focus:ring-2 focus:ring-blue-500"
                    >
                        Login
                    </button>
                </form>
            </div>
        </div>
    );
};
