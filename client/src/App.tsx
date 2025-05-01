import React, {useContext, useState} from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route, useLocation } from 'react-router-dom';
import { LoginPage } from './pages/LoginPage';
import { DashboardPage } from './pages/DashboardPage';
import { AuditPage } from './pages/AuditPage';
import { InventoryPage } from './pages/InventoryPage';
import { AuthContext } from './AuthContext';
import { TopMenu } from './menu/TopMenu';
import { SideMenu } from './menu/SideMenu';
import {DialogBox} from "./components/dialog/DialogBox";
import {DialogContext, UIContext} from "./UIContext";

function AppContent() {
    const location = useLocation();
    const isLoginPage = location.pathname === '/';
    const dialogContext = useContext(DialogContext);

    const pageVsTabs: { [index: string]: {page: string, link: string}[] } = {
        '/inventory': [{
            page: "Virtual Machines",
            link: "/inventory/vm"
        },
            {
                page: "Containers",
                link: "/inventory/cnt"
            }, {
                page: "Physical Machines",
                link: "/inventory/physical"
            }]
    }

    return (<>
        {dialogContext.isDialogOpen && <DialogBox title={dialogContext.dialogTitle} description={dialogContext.dialogContent} />}
        <div className={`flex flex-col h-screen ${dialogContext.isDialogOpen && "dialog-backdrop"}`}>
            {!isLoginPage && <TopMenu />}

            <div className="flex flex-1">
                {!isLoginPage && <SideMenu menu={pageVsTabs[location.pathname]} />}

                <main className={`flex-1 bg-gray-100 overflow-y-auto ${!isLoginPage && 'p-6'}`}>
                    <Routes>
                        <Route path="/" element={<LoginPage />} />
                        <Route path="/dashboard" element={<DashboardPage />} />
                        <Route path="/audit" element={<AuditPage />} />
                        <Route path="/inventory" element={<InventoryPage />} />
                    </Routes>
                </main>
            </div>
        </div>
        </>
    );
}

function App() {
    return (
        <AuthContext>
            <UIContext>
                <Router>
                    <AppContent />
                </Router>
            </UIContext>
        </AuthContext>
    );
}

export default App;