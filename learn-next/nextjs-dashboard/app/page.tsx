'use client'

import AcmeLogo from '@/app/ui/acme-logo';
import { ArrowRightIcon } from '@heroicons/react/24/outline';
import Link from 'next/link';
import styles from '@/app/ui/home.module.css';
import { lusitana } from './ui/fonts';
import Image from 'next/image';
import { useState } from 'react';
import { any } from 'zod';

export default function Page() {

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [birhtDate, setBirthDate] = useState('');
  const [salary, setSalary] = useState('');
  const [accountId, setAccountId] = useState('');

  const handleSubmit = () => {
    fetch('/createAccount', {
        method: 'POST',
        body: JSON.stringify({firstName, lastName, birhtDate, salary, accountId}),
    })
    
}

  return (
    <main className="flex min-h-screen flex-col p-6">
      <div className="flex h-20 shrink-0 items-end rounded-lg bg-blue-500 p-4 md:h-52">
        <AcmeLogo />
      </div>
      <div className="mt-4 flex grow flex-col gap-4 md:flex-row">
        <div className="flex flex-col justify-center gap-6 rounded-lg bg-gray-50 px-6 py-10 md:w-2/5 md:px-20">
        <div className={styles.shape}/>
        <div className='w-60'>
            <form action="" onSubmit={handleSubmit}>
                <input type="text" name="Firstname" placeholder='Firstname' onChange={(e) => setFirstName(e.target.value)} />
                <input type="text" name="Lastname" placeholder='Lastname' onChange={(e) => setLastName(e.target.value)}/>
                <input type="date" name="Birthdate" placeholder='Birthdate' onChange={(e) => setBirthDate(e.target.value)}/>
                <input type="number" name="Monthly net salary" placeholder='Monthly net salary' onChange={(e) => setSalary(e.target.value)}/>
                <input type="text" name="Account ID" placeholder='Account ID' onChange={(e) => setAccountId(e.target.value)}/>
                <Link
            href="/login"
            className="flex items-center gap-5 self-start rounded-lg bg-blue-500 px-6 py-3 text-sm font-medium text-white transition-colors hover:bg-blue-400 md:text-base"
          >
            <button type="submit">Submit</button> <ArrowRightIcon className="w-5 md:w-6" />
          </Link>
            </form>
        </div>     
          
        </div>
        <div className="flex items-center justify-center p-6 md:w-3/5 md:px-28 md:py-12">
          {/* Add Hero Images Here */}
          <Image
        src="/my-bank.jpg"
        width={1000}
        height={760}
        className="hidden md:block"
        alt="Screenshots of the dashboard project showing desktop version"
      />
        </div>
      </div>
    </main>
  );
}
